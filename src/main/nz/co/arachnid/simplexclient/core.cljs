(ns nz.co.arachnid.simplexclient.core
  (:require [rum.core :as rum]))

(def counter-atom (atom 0))

(rum/defc counter < rum/reactive []
  [:div { :on-click (fn [_] (swap! counter-atom inc)) }
   "Clicks: " (rum/react counter)])

(rum/mount (counter-atom) js/document.body)
