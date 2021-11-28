import PIL
from matplotlib import pyplot as plt
import matplotlib
from keras.preprocessing.image import ImageDataGenerator
from keras.models import load_model
from keras.models import Sequential
from keras.layers import Dense, Dropout
from keras.optimizers import RMSprop
from keras.layers import Dense, Dropout, Flatten
from keras.layers import Conv2D, MaxPooling2D
from keras.callbacks import EarlyStopping
from keras import backend as K
import keras
from time import time
from sklearn.metrics import classification_report, confusion_matrix
import numpy as np

#model = load_model("./Modelo_C32K44_C128k44_d075_D256_d05_D5.h5")
#model = load_model("./Modelo_C32k55_C64k55_d025_D128_d05_D5.h5")
model = load_model("./Modelo_C64k33_C128k33_d025_D256_d05_D5.h5")
model.fit
batch_size = 20
epochs = 100

train_data_dir = 'D:/Universidad/OneDrive - Universidad de Las Palmas de Gran Canaria/TERCERO/Fundamentos de los Sistemas Inteligentes/RedesNeuronales/cars_colours/train'
validation_data_dir = 'D:/Universidad/OneDrive - Universidad de Las Palmas de Gran Canaria/TERCERO/Fundamentos de los Sistemas Inteligentes/RedesNeuronales/cars_colours/test'

train_datagen = ImageDataGenerator(
        rescale=1./255,
        rotation_range=15,
        zoom_range=0.1
)

validation_datagen = ImageDataGenerator(
        rescale=1./255
)

validation_datagen = ImageDataGenerator(
        rescale=1./255
)

validation_generator = validation_datagen.flow_from_directory(
        validation_data_dir,
        target_size=(250, 150),
        batch_size=batch_size,
        class_mode='categorical')

train_generator = train_datagen.flow_from_directory(
        train_data_dir,
        target_size=(250, 150),
        batch_size=batch_size,
        class_mode='categorical')

validation_generator = validation_datagen.flow_from_directory(
        validation_data_dir,
        target_size=(250, 150),
        batch_size=batch_size,
        class_mode='categorical')

history = model.fit_generator(
        train_generator,
        epochs=epochs,
        validation_data = validation_generator,
        #callbacks = [es]
)

model.save("./T_100_Modelo_C64k33_C128k33_d025_D256_d05_D5.h5")

plt.plot(history.history['accuracy'], label='accuracy')
plt.plot(history.history['val_accuracy'], label='validation accuracy')
plt.plot(history.history['val_loss'], label='val_loss')
plt.plot(history.history['loss'], label='loss')

plt.title('Accuracy y Loss Clasificando coches por color')
plt.xlabel('Épocas')
plt.legend(loc="lower right")

plt.show()