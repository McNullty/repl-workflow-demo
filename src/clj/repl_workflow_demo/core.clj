(ns repl-workflow-demo.core
  (:require [mount.core :refer [defstate]]
           [repl-workflow-demo.config :refer [env]]))

;; This is main namespace with entry point for application.

(defstate http-server
  "**TODO:** For now this id a mock that is dependent on some other state"
  :start (println env)
  :stop (println "http-server is stopping"))
