package com.visitor.visitors;

import com.visitor.shapes.Circle;
import com.visitor.shapes.CompoundShape;
import com.visitor.shapes.Dot;
import com.visitor.shapes.Rectangle;
import com.visitor.shapes.Shape;

/**
 * Visitantes concretos implementam várias versões do mesmo
 * algoritmo, que pode trabalhar com todas as classes elemento
 * concretas.
 * 
 * Você pode usufruir do maior benefício do padrão Visitor
 * quando estiver usando ele com uma estrutura de objeto
 * complexa, tal como uma árvore composite. Neste caso, pode ser
 * útil armazenar algum estado intermediário do algoritmo
 * enquanto executa os métodos visitantes sobre vários objetos
 * da estrutura.
 */
public class XMLExportVisitor implements Visitor {

    public String export(Shape... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        for (Shape shape : args) {
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    /**
     * Exporta a ID do dot (ponto) e suas coordenadas de centro.
     * @param d
     * @return 
     */
    public String visitDot(Dot d) {
        return "<dot>" + "\n"
                + "    <id>" + d.getId() + "</id>" + "\n"
                + "    <x>" + d.getX() + "</x>" + "\n"
                + "    <y>" + d.getY() + "</y>" + "\n"
                + "</dot>";
    }

    /**
     * Exporta a ID do circle (círculo), coordenadas do centro, e raio.
     * @param c
     * @return 
     */
    public String visitCircle(Circle c) {
        return "<circle>" + "\n"
                + "    <id>" + c.getId() + "</id>" + "\n"
                + "    <x>" + c.getX() + "</x>" + "\n"
                + "    <y>" + c.getY() + "</y>" + "\n"
                + "    <radius>" + c.getRadius() + "</radius>" + "\n"
                + "</circle>";
    }

    /**
     * Exporta a ID do retângulo, coordenadas do topo à esquerda, largura e altura.
     * @param r
     * @return 
     */
    public String visitRectangle(Rectangle r) {
        return "<rectangle>" + "\n"
                + "    <id>" + r.getId() + "</id>" + "\n"
                + "    <x>" + r.getX() + "</x>" + "\n"
                + "    <y>" + r.getY() + "</y>" + "\n"
                + "    <width>" + r.getWidth() + "</width>" + "\n"
                + "    <height>" + r.getHeight() + "</height>" + "\n"
                + "</rectangle>";
    }

    /**
     * Exporta a ID da forma bem como a lista de ID dos seus filhos.
     * @param cg
     * @return 
     */
    public String visitCompoundGraphic(CompoundShape cg) {
        return "<compound_graphic>" + "\n"
                + "   <id>" + cg.getId() + "</id>" + "\n"
                + _visitCompoundGraphic(cg)
                + "</compound_graphic>";
    }

    private String _visitCompoundGraphic(CompoundShape cg) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : cg.children) {
            String obj = shape.accept(this);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }

}
