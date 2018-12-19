(ns grpc-server.core
  (:gen-class)
  (:import [io.grpc ServerBuilder]
           [io.grpc.examples.helloworld HelloReply GreeterGrpc$GreeterImplBase]))

(def service
  (proxy [GreeterGrpc$GreeterImplBase] []
    (sayHello [req resp]
      (let [reply (.build (.setMessage (HelloReply/newBuilder) (str "Hello" (.getName req))))]
        (.onNext resp reply)
        (.onCompleted resp)))))

(defn start-server []
  (.start (.build (.addService (ServerBuilder/forPort 50051) service))))

(defn -main [& args]
  (let [server (start-server)]
    (.addShutdownHook (Runtime/getRuntime) (Thread. #(.shutdown server)))
    (.awaitTermination server)))


