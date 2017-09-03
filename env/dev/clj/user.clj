(ns user)

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
