(defproject grpc-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [io.grpc/grpc-netty-shaded "1.17.1"]
                 [io.grpc/grpc-protobuf "1.17.1"]
                 [io.grpc/grpc-stub "1.17.1"]]
  :plugins [[lein-protoc "0.5.0"]]
  :java-source-paths ["src/java"]
  :source-paths ["src/clj"]
  :proto-target-path "src/java"
  :protoc-grpc true
  :main grpc-server.core
  :repl-options {:init-ns grpc-server.core})
