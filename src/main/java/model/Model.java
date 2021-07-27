package model;

import model.syntax.INode;
import model.syntax.binarynodes.operators.NodeMinus;
import model.syntax.binarynodes.operators.NodeOr;
import model.syntax.binarynodes.operators.NodePlus;
import model.syntax.binarynodes.operators.NodeTimes;
import model.syntax.endnodes.NodeBinary;
import model.syntax.endnodes.NodeEmpty;
import model.syntax.endnodes.NodeFloat;
import model.syntax.endnodes.NodeInt;
import model.syntax.unarynodes.operators.NodetoBinary;
import model.syntax.unarynodes.operators.NodetoInt;

/**
 * Front end for the model classes
 */
public class Model {
    public static INode tree =	new NodePlus(
            new NodeFloat(
                    6.9
            )
            ,
            new NodeOr(
                    new NodeBinary("1000")
                    ,
                    new NodetoBinary(
                            new NodeMinus(
                                    new NodeInt(25)
                                    ,
                                    new NodeBinary("0101") //0101
                            )
                    )
            )
    );

    // test tree 2
    public static INode tree2 = new NodePlus(
            new NodePlus(
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))),
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))))
            ),
            new NodePlus(
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))),
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))))
            )
    );

    // test tree 3
    INode tree3 = new NodeEmpty();

    // tree 4
    public static INode tree4 =	new NodePlus(
            new NodeFloat(
                    6.9
            )
            ,
            new NodeOr(
                    new NodeBinary("1000")
                    ,
                    new NodetoBinary(
                            new NodeMinus(
                                    new NodeInt(25)
                                    ,
                                    new NodeTimes(new NodetoInt(new NodeBinary("0101")), new NodeEmpty())
                            )
                    )
            )
    );
}
