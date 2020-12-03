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
   ;; Your task is to add a new key to the output
   ;; of this subscription: `:selected?`, containing
   ;; a boolean value that tells us whether the peg
   ;; is selected (highlighted).
   ;;
   ;; Remember that `db` will now contain `:selected-field`.
   ;;
   ;; Look at how the views in `solitaire.views` have changed.
   ;; We subscribe to this subscription in each `field-view`;
   ;; `field-view` passes it to `field-peg`, which assigns a
   ;; CSS class when the peg is selected.
   {:x x
    :y y
    :type (get-in db [:board y x])}))

(rf/reg-sub
 ::status
 (fn [db _]
   (:status db)))

(rf/reg-sub
 ::pegs-count
 :<- [::board]
 (fn [board _]
   (board/count-pegs board)))
