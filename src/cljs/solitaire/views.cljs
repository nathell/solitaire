(ns solitaire.views
  (:require
   [clojure.string :as string]
   [re-frame.core :as rf]
   [solitaire.subs :as subs]))

(defn field-blocked []
  [:div.field.field--blocked])

(defn field-empty []
  [:div.field])

(defn field-peg []
  [:div.field
   [:div.peg]])

(defn field-view [x]
  (case x
    :blocked [field-blocked]
    :empty [field-empty]
    :peg [field-peg]))

(defn board-view [board]
  (into
   [:div.board
    {:style {:grid-template-columns (string/join " " (repeat (count (first board)) "1fr"))}}]
   (for [row     board
         field   row]
     [field-view field])))

(defn main-panel []
  [:div
   [:h1 "Welcome to Solitaire!"]
   [board-view @(rf/subscribe [::subs/board])]])
