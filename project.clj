(defproject repl-workflow-demo "0.1.0-SNAPSHOT"
  :description "This project will demsontrate setting up development that is
compatible with Stuart Sierra reloaded workflow."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [mount "0.1.11"]
                 [cprop "0.1.11"]
                 [compojure "1.6.0"]
                 [luminus-immutant "0.2.3"]
                 [ring/ring-defaults "0.3.1"]]

;;dependencie for creating api documentation with codex `lein codox`
;; for inline documentation `lein marg ./src/clj/ ./env/dev/clj/`
  :plugins [[lein-codox "0.10.3"]
            [lein-marginalia "0.9.0"]]

  :source-paths ["src/clj"]
  :test-paths ["test/clj"]

  :profiles
  {:dev [:project/dev :profiles/dev]
   :project/dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                 :plugins [[lein-cprop "1.0.3"]]
                 :source-paths ["env/dev/clj"]
                 :resource-paths ["env/dev/resources"]
                 :jvm-opts ["-Dconf=.lein-env"]
                 :repl-options {:init-ns user}}})
