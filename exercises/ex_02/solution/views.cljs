(ns solitaire.views
  (:require [clojure.string :as string]
            [re-frame.core :as rf]
            [solitaire.board :as board]
            [solitaire.events :as events]
            [solitaire.subs :as subs]))

(defn field-blocked []
  [:div.field.field--blocked])

(defn field-empty []
  [:div.field])

(defn field-peg []
  [:div.field
   [:div.peg]])

(defn field-view [type]
  (case type
    :blocked [field-blocked]
    :empty [field-empty]
    :peg [field-peg]))

(defn board-view [board]
  (let [[width height] (board/dimensions board)]
    (into [:div.board]
          (for [row   board
                field row]
            [field-view field]))))

(defn main-panel []
  [:div
   [board-view board/initial-board]])
