(ns solitaire.views
  (:require [clojure.string :as string]
            [re-frame.core :as rf]
            [solitaire.events :as events]
            [solitaire.subs :as subs]))

(defn hello [{:keys [who color bold?]}]
  [:p {:style {:color color}}
   "Hello, "
   (if bold?
     [:b who]
     who)
   "!"])

(defn main-panel []
  [:div
   [hello {:who "World", :color "green"}]
   [hello {:who "re:Clojure", :color "red", :bold? true}]])
