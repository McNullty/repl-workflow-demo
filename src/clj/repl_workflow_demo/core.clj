(ns repl-workflow-demo.core
  (:require [mount.core :refer [defstate]]
            [luminus.http-server :as http]
            [repl-workflow-demo.config :refer [env]]
            [repl-workflow-demo.routes.home :refer [app]]))

;; This is main namespace with entry point for application.

;; Http server is using [luminus-immutant "0.2.3"] library for managin lifecycle of web server

;; Function http/start accepts map with two mandatary keys, :handler and :port. Port is already configured in evironment, but we could overide it here. There are optional keys that we coud set. List can be find [here] (http://immutant.org/documentation/current/apidoc/immutant.web.html)
;; If we want to set default path we need to use keyword :handler-path and not :path as it is described in imutant documentation.
;;
;; We could also assign additional handlers to diferent paths using http/wrap-handler as described in [here](https://github.com/luminus-framework/luminus-immutant)
(defstate http-server
  "luminus-immutant server"
  :start (http/start
           (-> env
             (assoc :handler (app))
             (assoc :handler-path "/test")))
  :stop (http/stop http-server))
