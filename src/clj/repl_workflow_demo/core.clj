(ns repl-workflow-demo.core
  (:require [mount.core :refer [defstate]]
            [luminus.http-server :as http]
            [repl-workflow-demo.config :refer [env]]
            [repl-workflow-demo.routes.home :refer [app]]))

;; This is main namespace with entry point for application.

;; Http server is using [luminus-immutant "0.2.3"] library for managin lifecycle of web server

(defstate http-server
  "luminus-immutant server"
  :start (http/start {:handler app :port 3300})
  :stop (http/stop http-server))
