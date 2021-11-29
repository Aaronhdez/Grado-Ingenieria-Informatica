/**
 * \file color.cpp
 * \brief class to manage color values
 * \author Luis Alvarez \n \n
*/


#include "color.h"

void color::hsv2rgb(const float &h,const float &s,const float &v){
  float
    H = h*360./255.,
    S = s/255.,
    V = v/255.,
    R = 0, G = 0, B = 0
  ;
  if (H==0 && S==0) R = G = B = V;
  else {
    H/=60.;
    const int i = (int)floor(H)%6;
    const float
      f = (i&1)?(H - i):(1 - H + i),
      m = V*(1 - S),
      n = V*(1 - S*f);
    switch (i) {
      case 6 :
      case 0 : R = V; G = n; B = m; break;
      case 1 : R = n; G = V; B = m; break;
      case 2 : R = m; G = V; B = n; break;
      case 3 : R = m; G = n; B = V; break;
      case 4 : R = n; G = m; B = V; break;
      case 5 : R = V; G = m; B = n; break;
    }
  }
  R*=255; G*=255; B*=255;
  R_ = (unsigned char) (R<0?0:(R>255?255:R));
  G_ = (unsigned char) (G<0?0:(G>255?255:G));
  B_ = (unsigned char) (B<0?0:(B>255?255:B));
}

void color::rgb2hsv(float &H,float &S,float &V){
  float rgb_min,rgb_max;
  rgb_min=rgb_max=R_;
  if(rgb_min>G_) rgb_min=G_;
  if(rgb_min>B_) rgb_min=B_;
  if(rgb_max<G_) rgb_max=G_;
  if(rgb_max<B_) rgb_max=B_;
  if(rgb_max == 0){
    H=0;
    S=0;
    V=0;  //HSV
    return;
  }
  V= rgb_max;   //V
  S= 255.*(rgb_max - rgb_min)/rgb_max;  //S
  if(S==0){
    H=0; //H
    return;
  }
  //H
  if(rgb_max==R_){
    H=0.+43.*((int) G_ - B_)/(rgb_max - rgb_min);
  }
  else if (rgb_max == G_) {
    H= 85.+ 43.*((int) B_-R_)/(rgb_max - rgb_min);
  }
  else{
    H= 171. + 43.*((int) R_ - G_)/(rgb_max - rgb_min);
  }
}


