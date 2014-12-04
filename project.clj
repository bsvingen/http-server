(defproject com.borkdal/http-server "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [http-kit "2.1.16"]
                 [com.novemberain/pantomime "2.3.0"]]
  :main com.borkdal.http-server.core
  :plugins [[lein-bin "0.3.4"]]
  :bin {:name "http-server"}
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[midje "1.6.3"]
                                  [clj-http "1.0.1"]]}})

