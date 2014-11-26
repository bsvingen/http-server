(ns com.borkdal.http-server.core
  (:require [com.borkdal.http-server.server :as server])
  (:gen-class))

(defn -main
  [port]
  (println "Starting server")
  (server/start-server (Integer. port)))

