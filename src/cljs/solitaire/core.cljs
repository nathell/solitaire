(ns solitaire.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [solitaire.events :as events]
            [solitaire.views :as views]
            [solitaire.config :as config]
            [solitaire.fx :as fx]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
