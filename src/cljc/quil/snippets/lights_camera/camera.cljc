(ns quil.snippets.lights-camera.camera
  (:require #?(:clj [quil.snippets.macro :refer [defsnippet]])
            [quil.core :as q :include-macros true]
            quil.snippets.all-snippets-internal)
  #?(:cljs
     (:use-macros [quil.snippets.macro :only [defsnippet]])))

(defsnippet camera
  "camera"
  {:renderer :p3d}

  (q/background 255)
  (q/camera 200 200 200 0 0 0 0 0 -1)

  (q/stroke-weight 2)
  (q/stroke 0)
  (q/fill 127)
  #?(:clj (do (q/box 100)
              (q/stroke 255 0 0) ; red - x axis
              (q/line 0 0 0 100 0 0)
              (q/stroke 0 255 0) ; green - Y axis
              (q/line 0 0 0 0 100 0)
              (q/stroke 0 0 255) ; blue - Z axis
              (q/line 0 0 0 0 0 100)))
  #?(:cljs (do
             (q/box 100))))

#?(:clj
   (defsnippet frustum
     "frustum"
     {:renderer :p3d}

     (q/background 255)
     (q/camera 200 200 200 0 0 0 0 0 -1)
     (q/frustum -100 100 -100 100 200 330)

     (q/stroke-weight 2)
     (q/stroke 0)
     (q/fill 127)
     (q/box 100)
     (q/stroke 255 0 0) ; red - X axis
     (q/line 0 0 0 100 0 0)
     (q/stroke 0 255 0) ; green - Y axis
     (q/line 0 0 0 0 100 0)
     (q/stroke 0 0 255) ; blue - Z axis
     (q/line 0 0 0 0 0 100)))

(defsnippet ortho
  "ortho"
  {:renderer :p2d}

  (let [ortho-params [[] [0 300 0 300] [0 300 0 300 0 170]]
        pos [[0 0] [250 0] [127 250]]]
    (dotimes [ind (count ortho-params)]
      (let [gr (q/create-graphics 240 240 :p3d)]
        (q/with-graphics gr
          (q/background 255)
          (q/camera 100 100 100 0 0 0 0 0 -1)
          (apply q/ortho (nth ortho-params ind))
          (q/fill 127)
          (q/box 100))
        (apply q/image gr (nth pos ind))))))

(defsnippet perspective
  "perspective"
  {:renderer :p2d}

  (let [perspective-params [[] [(/ q/PI 2) 0.5 50 300]]
        pos [[0 0] [250 0] [127 250]]]
    (dotimes [ind (count perspective-params)]
      (let [gr (q/create-graphics 240 240 :p3d)]
        (q/with-graphics gr
          (q/background 255)
          (q/camera 100 100 100 0 0 0 0 0 -1)
          (apply q/perspective (nth perspective-params ind))
          (q/fill 127)
          (q/box 100))
        (apply q/image gr (nth pos ind))))))

#?(:clj
   (defsnippet print-camera
     "print-camera"
     {:renderer :p3d}

     (q/print-camera)))

#?(:clj
   (defsnippet print-projection
     "print-projection"
     {:renderer :p3d}

     (q/print-projection)))
