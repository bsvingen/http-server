(ns com.borkdal.http-server.server
  (:require [clojure.java.io :as io]
            [org.httpkit.server :as server]
            [pantomime.mime :as pantomime]))

(defn make-async-handler
  [directory]
  (fn async-handler [ring-request]
    (let [pathname (str directory (:uri ring-request))
          file (io/as-file pathname)]
      (println pathname)
      (server/with-channel ring-request channel
        (server/send! channel
                      {:status 200
                       :headers {"Content-Type" (pantomime/mime-type-of pathname)}
                       :body    file})))))

(defn start-server
  "Starts server, returns function for stopping the server"
  [port]
  (server/run-server (make-async-handler (System/getProperty "user.dir"))
                     {:port port}))

