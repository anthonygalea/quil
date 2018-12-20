(ns quil.snippets.lights-camera.material-properties
  (:require #?(:clj [quil.snippets.macro :refer [defsnippet]])
            [quil.core :as q :include-macros true]
            quil.snippets.all-snippets-internal)
  #?(:cljs
     (:use-macros [quil.snippets.macro :only [defsnippet]])))

#?(:clj
   (defsnippet ambient
     "ambient"
     {:renderer :p3d}

     (q/background 0)
     (q/camera 150 150 150 0 0 0 0 0 -1)
     (q/ambient-light 255 127 127)
     (q/ambient 255 127 0)
     (q/box 100)
     (q/translate 0 100 0)
     (q/ambient 127)
     (q/sphere 40)))

#?(:clj
   (defsnippet emissive
     "emissive"
     {:renderer :p3d}

     (q/background 0)
     (q/camera 150 150 150 0 0 0 0 0 -1)
     (q/ambient-light 255 127 127)
     (q/emissive 0 0 255)
     (q/box 100)
     (q/translate 0 100 0)
     (q/emissive (q/color 0 127 0))
     (q/sphere 40)))

#?(:clj
   (defsnippet shininess
     "shininess"
     {:renderer :p3d}

     (q/background 0)
     (q/camera 150 150 150 0 25 0 0 0 -1)
     (q/fill 127 0 255)
     (q/no-stroke)
     (q/light-specular 204 204 204)
     (q/directional-light 102 102 102 -1 -1 -1)
     (q/specular 255 255 255)
     (q/shininess 2)
     (q/sphere 50)
     (q/translate 0 100 0)
     (q/shininess 10)
     (q/sphere 40)))

#?(:clj
   (defsnippet specular
     "specular"
     {:renderer :p3d}

     (q/background 0)
     (q/camera 150 150 150 0 25 0 0 0 -1)
     (q/no-stroke)
     (q/fill 0 51 102)
     (q/light-specular 255 255 255)
     (q/directional-light 204 204 204 -1 -1 -1)
     (q/specular 255)
     (q/sphere 50)
     (q/translate 0 100 0)
     (q/specular 204 102 0)
     (q/sphere 40)))
