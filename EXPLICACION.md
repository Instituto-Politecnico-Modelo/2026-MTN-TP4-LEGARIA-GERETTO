# Sistema de Tendencias Musicales - Patrón State

## Descripción general

El sistema modela la popularidad de una canción usando el patrón de diseño **State**. Una canción tiene un estado de popularidad que puede ser: **Normal**, **Auge** o **Tendencia**. Cada estado define su propio icono, formato de leyenda y reglas de transición a otros estados.

---

## Estados y transiciones

```
Normal  ──(>1000 reproducciones)──▶  Auge
Auge    ──(>50000 repro + >20000 likes)──▶  Tendencia
Auge    ──(>=5000 dislikes)──▶  Normal
Tendencia ──(24hs sin reproducción)──▶  Normal
```

### Normal
- **Icono:** Musical Note 🎵
- **Formato de leyenda:** `Nombre del artista - Nombre del álbum - Título de la canción`
- **Transición:** Cuando supera las 1000 reproducciones en este estado, pasa a **Auge**.

### Auge
- **Icono:** Rocket 🚀
- **Formato de leyenda:** `Nombre del artista - Título de la canción (Nombre del álbum - año del álbum)`
- **Transiciones:**
  - Si supera 50.000 reproducciones **y** tiene más de 20.000 likes → pasa a **Tendencia**.
  - Si alcanza 5.000 dislikes → vuelve a **Normal**.

### Tendencia
- **Icono:** Fire 🔥
- **Formato de leyenda:** `Título de la canción - Nombre del artista (Nombre del álbum - año del álbum)`
- **Transición:** Si no fue reproducida durante las últimas 24 horas → vuelve a **Normal**.

---

## Estructura de clases

| Clase | Rol en el patrón | Descripción |
|---|---|---|
| **Cancion** | Contexto | Contiene el título, artista, álbum y una referencia al estado actual de popularidad. Delega las acciones (reproducir, darLike, darDislike) al estado. |
| **Popularidad** | State (abstracto) | Clase abstracta que define los métodos que cada estado concreto debe implementar: `getIcono()`, `getLeyenda()`, `reproducir()`, `darLike()`, `darDislike()`, `pasaron24HsSinReproduccion()`. |
| **Normal** | Estado concreto | Implementa el comportamiento cuando la canción tiene popularidad normal. Cuenta reproducciones y transiciona a Auge. |
| **Auge** | Estado concreto | Implementa el comportamiento cuando la canción está en auge. Cuenta reproducciones, likes y dislikes para decidir si transiciona a Tendencia o vuelve a Normal. |
| **Tendencia** | Estado concreto | Implementa el comportamiento cuando la canción es tendencia. Transiciona a Normal si pasan 24hs sin reproducción. |
| **Artista** | Modelo | Almacena el nombre del artista. |
| **Album** | Modelo | Almacena el nombre y año del álbum. |
| **Icono** | Utilidad | Almacena la codificación de los emojis y los convierte a texto. |

---

## Funcionamiento del patrón State

1. `Cancion` tiene un atributo `popularidad` de tipo `Popularidad` (la clase abstracta).
2. Cuando se llama a `cancion.reproducir()`, la canción delega la llamada al estado actual: `popularidad.reproducir(this)`.
3. Cada estado concreto (`Normal`, `Auge`, `Tendencia`) implementa la lógica de transición. Cuando se cumple una condición, el estado cambia la popularidad de la canción llamando a `cancion.setPopularidad(new OtroEstado())`.
4. Al llamar a `cancion.mostrarDetalle()`, se delega al estado actual, que retorna el string con formato `icono-leyenda` según sus propias reglas.

---

## Ejemplo con datos de prueba

Canción: "The Scientist" | Artista: "Coldplay" | Álbum: "A Rush of Blood to the Head" (2002)

1. **Canción recién lanzada (Normal):** `🎵-Coldplay - A Rush of Blood to the Head - The Scientist`
2. **Supera 1000 reproducciones (Auge):** `🚀-Coldplay - The Scientist (A Rush of Blood to the Head - 2002)`
3. **Recibe 5000 dislikes (vuelve a Normal):** `🎵-Coldplay - A Rush of Blood to the Head - The Scientist`
4. **Supera 50000 reproducciones + 20000 likes (Tendencia):** `🔥-The Scientist - Coldplay (A Rush of Blood to the Head - 2002)`
5. **24hs sin reproducción (vuelve a Normal):** `🎵-Coldplay - A Rush of Blood to the Head - The Scientist`
