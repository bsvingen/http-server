(ns com.borkdal.http-server.server_test
  (:require [com.borkdal.http-server.server :refer :all]
            [clj-http.client :as client]
            [midje.sweet :refer :all])
  (:import [java.net ServerSocket]))

(facts "testing server"
  (letfn [(get-free-port []
            (let [socket (ServerSocket. 0)
                  port (.getLocalPort socket)]
              (.close socket)
              port))]
    (let [port (get-free-port)
          filename "resources/test/test_page.html"
          good-url (str "http://localhost:" port "/" filename)
          bad-url (str "http://localhost:" port "/" "dummy.html")
          stop-server (start-server port)]
      (facts "good URL"
        (let [{:keys [status body]} (client/get good-url)]
          (fact "status code"
            status => 200)
          (fact "body"
            body => (slurp filename))))
      (facts "bad URL"
        (try
          (client/get bad-url)
          (catch clojure.lang.ExceptionInfo exception-info
            (let [{:keys [status body]} (:object (.getData exception-info))]
              (fact "status code"
                status => 404)
              (fact "body"
                (.startsWith body "Cannot find ") => true)))))
      (stop-server))))

