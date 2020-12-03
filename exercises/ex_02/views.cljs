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
    ;; Modify this function to render all the fields of the board.
    ;; There should be 49 elements nested within the `div.board`,
    ;; following row-major order, as follows:
    ;;
    ;; [:div.board
    ;;  [field-view :blocked] ; row 1
    ;;  [field-view :blocked]
    ;;  [field-view :peg]
    ;;  [field-view :peg]
    ;;  [field-view :peg]
    ;;  [field-view :blocked]
    ;;  [field-view :blocked]
    ;;  [field-view :blocked] ; row 2
    ;;  ...]
    ;;
    ;; Hint: Use `for` to iterate over `board` and construct
    ;; the sequence of `field-view`s,
    ;; and then `into` to nest it into the outer `div.board`.
    ;;
    ;; Note: The field-views should be flattened (so don't wrap each row
    ;; in its own `div`).
    [:div.board
     [field-view :peg]]))

(defn main-panel []
  [:div
   [board-view board/initial-board]])
