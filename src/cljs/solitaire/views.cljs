(ns solitaire.views
  (:require
   [clojure.string :as string]
   [re-frame.core :as rf]
   [solitaire.events :as events]
   [solitaire.subs :as subs]))

(defn field-blocked []
  [:div.field.field--blocked])

(defn field-empty [{:keys [x y]}]
  [:div.field {:on-click #(rf/dispatch [::events/make-move x y])}])

(defn field-peg [{:keys [selected? x y]}]
  [:div.field
   [:div.peg {:class (when selected? "peg--selected")
              :on-click #(rf/dispatch [::events/select-field x y])}]])

(defn field-view [{:keys [type selected?] :as field}]
  (case type
    :blocked [field-blocked]
    :empty [field-empty field]
    :peg [field-peg field]))

(defn board-view []
  (let [[height width] @(rf/subscribe [::subs/board-dimensions])]
    (into
     [:div.board
      {:style {:grid-template-columns (string/join " " (repeat width "1fr"))
               :grid-template-rows (string/join " " (repeat height "1fr"))}}]
     (for [y (range height)
           x (range width)]
       [field-view @(rf/subscribe [::subs/field x y])]))))

(defn main-panel []
  [:div
   [:h1 "Welcome to Solitaire!"]
   [board-view]
   [:p "Game over: " @(rf/subscribe [::subs/game-over?])]])
