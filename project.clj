;; NOTE! This project requires leiningen 2.1.0 or later.
(require 'leiningen.core.eval)
;;(println (leiningen.core.eval/get-os)) ;; try lein deps to see this

(def LWJGL-CLASSIFIER
  "Per os native code classifier"
  {:macosx "natives-osx"
   :linux "natives-linux"
   :windows "natives-windows"}) ;; TESTME

(defn lwjgl-classifier
  "Return the os-dependent lwjgl native-code classifier"
  []
  (let [os (leiningen.core.eval/get-os)]
    (get LWJGL-CLASSIFIER os)))

(defproject hello_lwjgl "0.1.0-SNAPSHOT"
  :description "Simple LWJGL clojure test."
  :url "https://github.com/rogerallen/hello_lwjgl"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.lwjgl.lwjgl/lwjgl "2.9.0"]
                 [org.lwjgl.lwjgl/lwjgl_util "2.9.0"]
                 [org.lwjgl.lwjgl/lwjgl-platform "2.9.0" 
                  :classifier ~(lwjgl-classifier)
                  :native-prefix ""]]
  :main hello-lwjgl.core)
