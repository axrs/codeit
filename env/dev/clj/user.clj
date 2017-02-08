(ns user
  (:require [mount.core :as mount]
            [codeit.figwheel :refer [start-fw stop-fw cljs]]
            codeit.core))

(defn start []
  (mount/start-without #'codeit.core/http-server
                       #'codeit.core/repl-server))

(defn stop []
  (mount/stop-except #'codeit.core/http-server
                     #'codeit.core/repl-server))

(defn restart []
  (stop)
  (start))


