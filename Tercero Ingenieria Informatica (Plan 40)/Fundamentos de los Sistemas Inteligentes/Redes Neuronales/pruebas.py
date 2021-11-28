from keras.preprocessing.image import ImageDataGenerator
import numpy as np
from keras.models import load_model
from keras.preprocessing.image import ImageDataGenerator
from sklearn.metrics import confusion_matrix
from sklearn.metrics import plot_confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt

#model = load_model("./Modelo_C16k44_C32k44_d025_D128_d05_D5.h5")
#model = load_model("./Modelo_C32k33_C64k33_C128k33_d025_D256_d05_D5.h5")
#model = load_model("./Modelo_C32k33_C64k33_d025_D128_d05_D5.h5")
#model = load_model("./Modelo_C32K33_C128k33_C256k33_d05_D256_d05_D5.h5")
#model = load_model("./T_100_Modelo_C32K44_C128k44_d075_D256_d05_D5.h5")
#model = load_model("./Modelo_C32K55_C64k55_C128k55_d05_D128_d05_D5.h5")
#model = load_model("./T_100_Modelo_C32k55_C64k55_d025_D128_d05_D5.h5")
model = load_model("./T_100_Modelo_C32k44_C128k44_d075_D256_d05_D5.h5")
batch_size = 10

# # CONFUSION MATRIX
validation_datagen = ImageDataGenerator(
        rescale=1./255
)

# Aplicamos los mismos cambios para el conjunto de validación
validation_data_dir = 'D:/Universidad/OneDrive - Universidad de Las Palmas de Gran Canaria/TERCERO/Fundamentos de los Sistemas Inteligentes/RedesNeuronales/cars_colours/test'
validation_generator = validation_datagen.flow_from_directory(
        validation_data_dir,
        shuffle=False,
        target_size=(250, 150),
        batch_size=batch_size,
        class_mode='categorical')

Y_pred = model.predict(validation_generator)

# EVALUACIÓN
model.evaluate(validation_generator, steps=None, max_queue_size=10, workers=1, use_multiprocessing=False)

# Valor De las imagenes según su etiqueta
print(validation_generator.classes)

# Valor De las imagenes según su predicción
print(np.argmax(model.predict(validation_generator), axis=1))

y_pred = np.argmax(Y_pred, axis=1)

# print('Confusion Matrix')
cfm = confusion_matrix(validation_generator.classes, y_pred)
# fig, ax = plt.subplots(figsize=(7.5, 7.5))
# ax.matshow(cfm, cmap=plt.cm.Blues, alpha=0.3)
# for i in range(cfm.shape[0]):
#         for j in range(cfm.shape[1]):
#                 ax.text(x=j, y=i, s=cfm[i, j], va='center', ha='center', size='xx-large')
#
# plt.xlabel('Predictions', fontsize=18)
# plt.ylabel('Actuals', fontsize=18)
# plt.title('Confusion Matrix', fontsize=18)
# plt.show()

from mlxtend.plotting import plot_confusion_matrix

fig, ax = plot_confusion_matrix(conf_mat=cfm, figsize=(6, 6), cmap=plt.cm.Greens)
plt.xlabel('Predicciones', fontsize=18)
plt.ylabel('Clases', fontsize=18)
plt.title('Matriz de Confusión', fontsize=18)
plt.show()


#PRUEBAS AISLADAS

# pil_im = Image.open("D:/Universidad/OneDrive - Universidad de Las Palmas de Gran Canaria/TERCERO/Fundamentos de los Sistemas Inteligentes/RedesNeuronales/cars_colours/test/3/00262.jpg")
# im = np.asarray(pil_im.resize((250, 150)))
# imshow(im)
#
# im = im.reshape(1,250,150,3)
# prediction = model.predict(im)
# res = prediction[0]
# print(res)
#
# if np.argmax(res) == 0:
#   print("Black")
# elif np.argmax(res) == 1:
#   print("Blue")
# elif np.argmax(res) == 2:
#   print("Red")
# elif np.argmax(res) == 3:
#   print("White")
# else:
#   print("Yellow")


# # CLASIFICATION REPORT
# print('Classification Report')
# print(classification_report(validation_generator.classes, y_pred, target_names=target_names))