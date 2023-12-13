case class Person(firstName: String, lastName: String, age: Int, sex: String) {}

@main def hello: Unit = {

  val people = List(
    Person("John", "Doe", 23, "male"),
    Person("Joan", "Doe", 23, "female"),
    Person("Jean", "Chagal", 24, "male"),
    Person("Eva", "Robinson", 25, "female"),
    Person("Jorge", "Ramos", 22, "male"),
    Person("Janet", "Reed", 21, "female"),
    Person("Rob", "Jenkins", 26, "male"),
    Person("Maria", "Conde", 27, "female")
  )

  val peopleNames = people.map(person => {
    val prefix = if person.sex == "male" then "M:" else "F:"
    val res = s"$prefix ${person.firstName} ${person.lastName}"
    res
  })
  peopleNames.foreach(s => {
    println(s)
  })

  val malesCount = people.count(person => person.sex == "male")
  println(s"malesCount: $malesCount")
  val femalesCount = people.count(person => person.sex != "male")
  println(s"femalesCount: $femalesCount")
  val peopleCount = people.length
  println(s"peopleCount: $peopleCount")
  val averageAge = people
    .map(person => person.age)
    .reduce((acc, x) => acc + x) * 1.0 / peopleCount
  println(s"averageAge: $averageAge")

  val ageSumAndCount = people
    .map(person => (person.age, 1))
    .reduce((acc, ageCountTuple) => {
      val (ageSum, count) = acc
      val newAcc = (ageSum + ageCountTuple._1, count + 1)
      newAcc
    })
  val averageAge2 = ageSumAndCount._1 * 1.0 / ageSumAndCount._2
  println(s"averageAge2: $averageAge2")

  val maleAverageAge = people
    .filter(person => person.sex == "male")
    .map(person => person.age)
    .reduce((acc, x) => acc + x) * 1.0 / malesCount

  println(s"maleAverageAge: $maleAverageAge")

  val maleAgeSumAndCount = people
    .filter(person => person.sex == "male")
    .map(person => (person.age, 1))
    .reduce((acc, ageCountTuple) => {
      val (ageSum, count) = acc
      val newAcc = (ageSum + ageCountTuple._1, count + 1)
      newAcc
    })
  val maleAverageAge2 = maleAgeSumAndCount._1 * 1.0 / maleAgeSumAndCount._2
  println(s"maleAverageAge2: $maleAverageAge2")

  val femaleAverageAge = people
    .filter(person => person.sex != "male")
    .map(person => person.age)
    .reduce((acc, x) => acc + x) * 1.0 / femalesCount

  println(s"femaleAverageAge: $femaleAverageAge")

  val femaleAgeSumAndCount = people
    .filter(person => person.sex != "male")
    .map(person => (person.age, 1))
    .reduce((acc, ageCountTuple) => {
      val (ageSum, count) = acc
      val newAcc = (ageSum + ageCountTuple._1, count + 1)
      newAcc
    })
  val femaleAverageAge2 =
    femaleAgeSumAndCount._1 * 1.0 / femaleAgeSumAndCount._2
  println(s"femaleAverageAge2: $femaleAverageAge2")
}
