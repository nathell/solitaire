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
   (assoc db :selected-field
          (if (= (:selected-field db) [x y])
            nil
            [x y]))))
