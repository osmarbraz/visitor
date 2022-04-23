package com.visitor.shapes;

import com.visitor.visitors.Visitor;

/**
* O elemento interface declara um método `accept` que toma a
* interface do visitante base como um argumento.
*/
public interface Shape {

    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
