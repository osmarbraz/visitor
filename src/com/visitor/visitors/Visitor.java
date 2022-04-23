package com.visitor.visitors;

import com.visitor.shapes.Circle;
import com.visitor.shapes.CompoundShape;
import com.visitor.shapes.Dot;
import com.visitor.shapes.Rectangle;

/**
 * A interface visitante declara um conjunto de métodos visitantes que
 * correspondem com as classes elemento. A assinatura de um método visitante
 * permite que o visitante identifique a classe exata do elemento com o qual ele
 * está lidando.
 */
public interface Visitor {

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
