(ns solitaire.subs
  (:require
   [re-frame.core :as rf]
   [solitaire.db :as db]))

(rf/reg-sub
 ::board
 (fn [db _]
   (:board db)))

(rf/reg-sub
 ::board-dimensions
 :<- [::board]
 (fn [board _]
   (db/dimensions board)))

(rf/reg-sub
 ::field
 (fn [db [_ x y]]
   {:x x
    :y y
    :type (get-in db [:board y x])
    :selected? (= (:selected-field db) [x y])}))

(rf/reg-sub
 ::game-over?
 :<- [::board]
 (fn [board _]
   (if (db/game-over? board) "true" "false")))
