import org.scalatest.FlatSpec
object tree_build {

  def main(args: Array[String]): Unit = {

    case class Point(id: String, parent_id: String)

    case class Node(point: Point, children: Seq[Point])

    val point1 = Point("1", "0")
    val point2 = Point("2", "0")
    val point3 = Point("3", "1")
    val point4 = Point("4", "2")
    val point5 = Point("5", "3")
    val point6 = Point("6", "3")
    val point7 = Point("7", "4")
    val point8 = Point("8", "4")

    def createTree(points :Seq[Point]): Seq[Node] = {
      val node1 = Node(point1, Seq(point3))
      val node2 = Node(point2, Seq(point4))
      val node3 = Node(point3, Seq(point5, point6))
      val node4 = Node(point4, Seq(point7, point8))
      Seq(node1, node2, node3, node4)
    }
    println(createTree(Seq(point1, point2, point3, point4, point5, point6, point7, point8)))
    }
  }

