(ns solitaire.views
  (:require [clojure.string :as string]
            [re-frame.core :as rf]
            [solitaire.board :as board]
            [solitaire.events :as events]
            [solitaire.subs :as subs]))

(defn field-blocked []
  [:div.field.field--blocked])

(defn field-empty [{:keys [x y]}]
  ;; A new event has appeared in solitaire.events!
  ;; It's called `::events/make-move` and, when dispatched, returns
  ;; an app-db containing a new board, with the peg from `:selected-field`
  ;; having jumped to [x y].
  ;;
  ;; Your task is to augment this component to dispatch `::events/make-move`
  ;; when the player clicks the empty field.
  ;;
  ;; After completing this task, you'll be able to play Solitaire!
  [:div.field])

(defn field-peg [{:keys [selected? x y]}]
  [:div.field
   [:div.peg {:class (when selected? "peg--selected")
              :on-click #(rf/dispatch [::events/select-field x y])}]])

(defn field-view [{:keys [type] :as field}]
  (case type
    :blocked [field-blocked]
    :empty [field-empty field]
    :peg [field-peg field]))

(defn board-view []
  (let [[width height] @(rf/subscribe [::subs/board-dimensions])]
    (into
     [:div.board]
     (for [y (range height)
           x (range width)]
       [field-view @(rf/subscribe [::subs/field x y])]))))

(defn main-panel []
  [:div
   [board-view board/initial-board]])
