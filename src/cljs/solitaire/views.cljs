(ns solitaire.views
  (:require [clojure.string :as string]
            [re-frame.core :as rf]
            [solitaire.events :as events]
            [solitaire.subs :as subs]))

(defn hello [{:keys [who color]}]
  [:p {:style {:color color}}
   "Hello, " who "!"])

(defn main-panel []
  [:div
   [hello {:who "World", :color "green"}]
   [hello {:who "re:Clojure", :color "red"}]])
