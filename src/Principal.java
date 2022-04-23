
import com.visitor.shapes.Circle;
import com.visitor.shapes.CompoundShape;
import com.visitor.shapes.Dot;
import com.visitor.shapes.Rectangle;
import com.visitor.shapes.Shape;
import com.visitor.visitors.XMLExportVisitor;

public class Principal {

    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    /**
     * O código cliente pode executar operações visitantes sobre
     * quaisquer conjuntos de elementos sem saber suas classes
     * concretas. A operação accept (aceitar) direciona a chamada
     * para a operação apropriada no objeto visitante.
     * @param shapes 
     */
    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
