(ns solitaire.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 ::board
 (fn [db _]
   (:board db)))

(rf/reg-sub
 ::board-dimensions
 :<- [::board]
 (fn [board _]
   [(count (first board)) (count board)]))

(rf/reg-sub
 ::field
 (fn [db [_ x y]]
   {:type (get-in db [:board y x])
    :selected? (and (= x 0) (= y 2))}))
