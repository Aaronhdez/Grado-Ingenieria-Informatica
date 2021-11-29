/**
 * \file color.h
 * \brief class to manage color values
 * \author Luis Alvarez \n \n
*/


#ifndef COLOR_H_
#define COLOR_H_
#include <iostream>
#include <vector>
#include <stdlib.h>
#include <math.h>

/**
 * \class  color
 * \brief class  to store color
 * \author Luis Alvarez
 */
class color{
  public :
  unsigned char R_ /** red color channel */;
  unsigned char G_ /** green color channel */;
  unsigned char B_ /** blue color channel */;

  /// CONSTRUCTOR
  color(unsigned char R,unsigned char G,unsigned char B){R_=R; G_=G; B_=B;}
  color(){
    R_ = (unsigned char) (255.*rand()/RAND_MAX);
    G_ = (unsigned char) (255.*rand()/RAND_MAX);
    B_ = (unsigned char) (255.*rand()/RAND_MAX);
  };

  /// TRANSFORMATION FROM RGB TO HSV SPACE
  void hsv2rgb(const float &H,const float &S,const float &V);
  void rgb2hsv(float &H,float &S,float &V);

  /// CHANNEL ACCESS USING A VECTOR
  inline unsigned char &operator[](int k){
    switch (k) {
      case 0 : return(R_);
      case 1 : return(G_);
      default : return(B_);
    }
  }
};

#endif
