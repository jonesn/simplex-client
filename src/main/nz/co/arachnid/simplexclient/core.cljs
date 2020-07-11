(ns nz.co.arachnid.simplexclient.core
  (:require [rum.core :as rum]))

(def counter-atom (atom 0))

(rum/defc counter < rum/reactive []
  [:div { :on-click (fn [_] (swap! counter-atom inc))}
   "Clicks: " (rum/react counter-atom)])

;; =================================
;; Entry Hooks For Stop/Start/Reload
;; =================================

(defn ^:dev/before-load stop []
  (js/console.log "stop"))

(defn ^:dev/after-load start []
  (js/console.log "start")
  (rum/mount (counter) js/document.body))

(defn ^:export init []
  "Entry point for application, referenced in index.html"
  (js/console.log "Initializing Simplex Client Init")
  (rum/mount (counter) js/document.body))
