(ns repl-workflow-demo.routes.home
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;; This namespace contains all routes for http requests

(defroutes app-routes
  (GET "/" [] "<h1>Hello World!</h1>")
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (wrap-defaults app-routes site-defaults))
