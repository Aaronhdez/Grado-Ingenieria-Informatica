/*
 * Copyright (c) 2013-2014, Luis Alvarez <lalvarez@dis.ulpgc.es>
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under, at your option, the terms of the GNU General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version, or
 * the terms of the simplified BSD license.
 *
 * You should have received a copy of these licenses along this
 * program. If not, see <http://www.gnu.org/licenses/> and
 * <http://www.opensource.org/licenses/bsd-license.html>.
 */

#ifndef _BMP_H
#define _BMP_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <vector>
#include "color.h"

#include "lodepng.h"

using namespace std;

typedef struct {
   unsigned short int type;                 /* Magic identifier            */
   unsigned int size;                       /* File size in bytes          */
   unsigned short int reserved1, reserved2;
   unsigned int offset;                     /* Offset to image data, bytes */
} HEADER;
typedef struct {
   unsigned int size;               /* Header size in bytes      */
   int width,height;                /* Width and height of image */
   unsigned short int planes;       /* Number of colour planes   */
   unsigned short int bits;         /* Bits per pixel            */
   unsigned int compression;        /* Compression type          */
   unsigned int imagesize;          /* Image size in bytes       */
   int xresolution,yresolution;     /* Pixels per meter          */
   unsigned int ncolours;           /* Number of colours         */
   unsigned int importantcolours;   /* Important colours         */
} INFOHEADER;



class imageBMP{

  int width_;
  int height_;
  int size_;
  vector<color> RGB_;

  public:
  inline int width() const {return width_;}
  inline int height() const {return height_;}
  inline int size() const {return width_*height_;}
  inline color &operator[](int k){
//    if(k<0 || k>=RGB_.size()){
//      printf("k=%d RGB_.size()=%d\n",k,RGB_.size());
//      system("pause");
//    }
    return(RGB_[k]);
  }
  inline color operator[](int k)const {return(RGB_[k]);}
  void equal(color c){for(int k_=0;k_<(int) RGB_.size();k_++) RGB_[k_]=c;}


  imageBMP(const char *fileName /** INPUT FILE NAME */ );
  int write(const char *name);
  imageBMP(){width_=height_=size_=0;}
  imageBMP(int width,int height){
    width_=width; height_=height; size_=width*height; RGB_.resize(size_);
  };
  imageBMP(int width,int height,color c){
    width_=width; height_=height; size_=width*height; RGB_.resize(size_);
    for(int k=0;k<size_;k++){RGB_[k]=c;}
  };
  imageBMP symmetry(int number_of_sectors,int initial_sector,float center_x,float center_y,float angle0);
  imageBMP symmetry45();

  /// WE JOINT 2 IMAGES (HORIZONTAL)
  imageBMP joint(imageBMP &I);

  /// WE JOINT 2 IMAGES (VERTICAL)
  imageBMP jointV(imageBMP &I);

  /// WE APPLY A ZOOM FACTOR TO THE IMAGE
  imageBMP zoom(const float &zoom);

  /// SORT RANDOMLY
  imageBMP sort();

  /// SORT HSV
  imageBMP sortHSV();

  /// GET A ROI FROM THE IMAGE
  imageBMP roi(int x0,int y0,int x1,int y1);

  /// GENERATION OF A VIDEO BY ZOOMING
  void video_generation(int x0,int y0,int FinalWidth,int Nframes);

  /// WIDTH EXTENSION
  imageBMP width_extension(int newWidth);


};

vector<float> ami_gauss_conv_alma(vector<float> &If,float sigma_x,float sigma_y,float precision,int width,int height);
vector<float> zoom(vector<float> &If,int &width,int &height,float zoom);
float zoom(vector<float> &If,int &width,int &height,float MinSqArea,float MaxSqArea,float sigma,float BinarizationSlope);
vector<float> ami_harris_value_estimation(imageBMP &I, float sigma);
void morphological_erosion2D(imageBMP &I,int Niter);
void morphological_dilation2D(imageBMP &I,int Niter);
void morphological_erosion2DLineRemoval(imageBMP &I,int Niter);
void morphological_dilation2DLineRemoval(imageBMP &I,int Niter);
void morphological_median2D(imageBMP &I,int Niter);


void ami_date_name(char name[200]);
double extract_zoom(char name[200]);




#endif /* !_BMP_H */






