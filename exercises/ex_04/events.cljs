(ns solitaire.events
  (:require
   [re-frame.core :as rf]
   [solitaire.board :as board]
   [solitaire.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-db
 ::select-field
 (fn [db [_ x y]]
   ;; Your task is to return the updated db with `:selected-field` set
   ;; to [x y], unless it's already [x y], in which case set it to
   ;; nil.
   ;;
   ;; Note that `solitaire.views/field-peg` has been updated to
   ;; dispatch this event on click.
   db))
