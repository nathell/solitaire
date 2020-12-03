(ns solitaire.views
  (:require [clojure.pprint :as pprint]
            [clojure.string :as string]
            [re-frame.core :as rf]
            [solitaire.board :as board]
            [solitaire.events :as events]
            [solitaire.subs :as subs]))

(defn main-panel []
  [:div
   [:h1 "Hello from workshop!"]
   [:p "Here's how an initial board looks like:"]
   [:pre (with-out-str (clojure.pprint/pprint board/initial-board))]])
