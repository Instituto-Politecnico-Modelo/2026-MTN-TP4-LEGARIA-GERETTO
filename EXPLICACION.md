# 🎵 ¿Cómo funciona el sistema de Tendencias Musicales?

## 🧩 La idea principal

Imaginate que una **canción** es como un dibujito que pintás en el jardín.

- Cuando lo pintás, **nadie lo conoce** todavía → es **Normal** 🎵
- Si a muchos nenes les gusta y lo miran mucho → se pone **En Auge** 🚀 (¡como un cohete!)
- Si MUCHÍSIMA gente lo mira y le da "me gusta" → se vuelve **Tendencia** 🔥 (¡está en llamas de lo popular!)

---

## 🔄 ¿Cómo cambia de estado?

Pensá en un semáforo, pero en vez de colores tiene **3 caritas**:

```
🎵 Normal  ──(mucha gente lo escucha)──▶  🚀 Auge
🚀 Auge    ──(MUCHA más gente + likes)──▶  🔥 Tendencia
🚀 Auge    ──(mucha gente dice "no me gusta")──▶  🎵 Normal
🔥 Tendencia ──(nadie lo escucha en todo un día)──▶  🎵 Normal
```

### 🎵 Normal (la canción es nueva)
- Tiene el dibujito de una **nota musical** 🎵
- Muestra: *quién canta - el disco - el nombre de la canción*
- Si **más de 1000 personas** la escuchan → sube a 🚀

### 🚀 En Auge (la canción está creciendo)
- Tiene el dibujito de un **cohete** 🚀
- Muestra: *quién canta - la canción (el disco - el año)*
- Si **más de 50.000** la escuchan Y **más de 20.000** le dan like → sube a 🔥
- Si **5.000 personas** le dan "no me gusta" → baja a 🎵

### 🔥 Tendencia (¡la canción es súper famosa!)
- Tiene el dibujito de **fuego** 🔥
- Muestra: *la canción - quién canta (el disco - el año)*
- Si **nadie la escucha en todo un día** → vuelve a 🎵

---

## 🏗️ ¿Cómo está armado? (Patrón State)

Hay **cajitas** (clases) y cada una tiene un trabajo:

| Cajita | ¿Qué hace? |
|---|---|
| 🎤 **Cancion** | Es la canción. Sabe su nombre, quién la canta y en qué disco está. Le pregunta a su "carita" (estado) qué mostrar. |
| 🎨 **Popularidad** | Es la regla general. Dice: "toda carita tiene que saber mostrar un icono y una leyenda". |
| 🎵 **Normal** | Una carita. Sabe qué hacer cuando la canción es nueva. |
| 🚀 **Auge** | Otra carita. Sabe qué hacer cuando la canción está creciendo. |
| 🔥 **Tendencia** | Otra carita. Sabe qué hacer cuando la canción es súper famosa. |
| 🧑‍🎤 **Artista** | Guarda el nombre del cantante (ej: "Coldplay"). |
| 💿 **Album** | Guarda el nombre del disco y el año (ej: "A Rush of Blood to the Head", 2002). |
| 😀 **Icono** | Guarda los dibujitos (emojis) para cada carita. |

---

## 🎯 Ejemplo con "The Scientist" de Coldplay

1. **Sale la canción** → 🎵 `Coldplay - A Rush of Blood to the Head - The Scientist`
2. **La escuchan 1001 veces** → 🚀 `Coldplay - The Scientist (A Rush of Blood to the Head - 2002)`
3. **5000 personas le dan "no me gusta"** → 🎵 vuelve a ser Normal
4. **La escuchan muchísimo + muchos likes** → 🔥 `The Scientist - Coldplay (A Rush of Blood to the Head - 2002)`
5. **Nadie la escucha en 24 horas** → 🎵 vuelve a ser Normal

---

> **En resumen:** La canción tiene una "carita" que cambia según cuánta gente la escucha. Cada carita sabe qué dibujito mostrar y cuándo cambiar a otra carita. ¡Eso es el patrón State! 🧩
