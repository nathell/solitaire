(ns solitaire.subs
  (:require [re-frame.core :as rf]
            [solitaire.board :as board]))

(rf/reg-sub
 ::board
 (fn [db _]
   (:board db)))

(rf/reg-sub
 ::board-dimensions
 :<- [::board]
 (fn [board _]
   (board/dimensions board)))

(rf/reg-sub
 ::field
 (fn [db [_ x y]]
   {:x x
    :y y
    :type (get-in db [:board y x])
    :selected? (= (:selected-field db) [x y])}))

(rf/reg-sub
 ::status
 (fn [db _]
   (:status db)))

(rf/reg-sub
 ::pegs-count
 :<- [::board]
 (fn [board _]
   (board/count-pegs board)))
