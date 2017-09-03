(ns repl-workflow-demo.config
 "This namespace is for creating env state that loads configurations from
  arguments that are passed to application, profiles defined in project.clj
  and profiles defined in profiles.clj"
 (:require [cprop.core :refer [load-config]]
           [cprop.source :as source]
           [mount.core :refer [args defstate]]))

;; This state loads configurations from arguments, config.edn and system
;; properties.
;;
;; it can be started in REPL by:
;; `(require '[mount.core :as mount])`
;; `(require '[repl-workflow-demo.config :as config])`
;; `(mount/start)`
;; This wil create state {:started ["#'repl-workflow-demo.config/env"]}
;; We can print this state with `(pprint repl-workflow-demo.config/env)`
;; or we can search for keywords `(:database-url repl-workflow-demo.config/env)`
;;
;; If we want to load config.edn it must be in resources path. If config.edn
;; file is not on resource path exceptin will be thrown: `RuntimeException could
;; not find a non empty configuration file to load. looked in the classpath (as
;; a "resource" and on a file system via "conf" system property
;;  cprop.core/load-config (core.cljc:24)`
;;
;; If we want to load propeties from profiles.clj
;; :plugins [[lein-cprop "1.0.3"]] must be set in dev profile and
;; :jvm-opts ["-Dconf=.lein-env"] must also be set.
;;
;; In production this would be set with ENV variables so we don't need to set it
;; for production environment.
;;
(defstate env
  "This is environment state that will have all configurations for all other
   states in our system"
  :start (load-config
           :merge
           [(args)
            (source/from-system-props)
            (source/from-env)]))
