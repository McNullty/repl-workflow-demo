(ns user
  (:require [mount.core :as mount]
            [mount-up.core :as mu]
            [clojure.tools.namespace.repl :as tn]
            repl-workflow-demo.core))

;; This namespace is to be used for speeding up repl development.
;;
;; It shoud have helper functions that will start system, start all states,
;; reload sources when changed, and restart system.
;;
;; For this namespace to work :source-paths ["env/dev/clj"] must be set i dev
;; profile. One additional thing that we can set is
;; :repl-options {:init-ns user}, this prperty will load user namespace first
;; thing when entering REPL
;;
;; For this namespace to be included in marginalia output we need to call:
;; `lein marg ./src/clj/ ./env/dev/clj/ `

;; **Warning** if there is compile error when running any of this functions repl will have to be restarted, `lein repl`

;; When you are in this namespace you can get doc for function with `(clojure.repl/doc f)`

(defn start
  "This function starts all states it finds"
  []
  (mount/start))

;; Because namespace repl-workflow-demo.config is required it will start env state.
;;
;; Start function now start states from namespace that we have required to current namespace, but we could explicitly sey what states should be started and stopped.
;;

(defn stop
  "This function stops all states it finds"
  []
  (mount/stop))

(defn refresh
  "This function looks for source files that have been changed since last this
   function has been run and reloads them. Before that it stops all states"
  []
  (stop)
  (tn/refresh))

(defn refresh-all
  "This function reloads all source files no metter if they have been changed or
   not. Before that it stops all states"
  []
  (stop)
  (tn/refresh-all))

(defn go
  "starts all states defined by defstate"
  []
  (start)
  :ready)

(defn reset
  "stops all states defined by defstate, reloads modified source files, and restarts the states"
  []
  (stop)
  (tn/refresh :after 'user/go))

;; Configure logging for mount library
;; TODO: think if this should be in production environment also
(mu/on-upndown :info mu/log :before)
