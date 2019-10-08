data class User(val id: Int, val firstName: String, val lastName: String) {
    val name: String get() = "$firstName $lastName"
}

data class Company(val id: Int, val name: String)

class DaoDatabase {
    fun query(statement: String): List<String> {
        return listOf()
    }
}

class Network {
    fun requestUser(id: Int) {}
}

//implicit parameter DaoDatabase uses explicit parameter User
fun DaoDatabase.queryUser(user: User) = this.query("SELECT * FROM Users WHERE userId = ${user.id}")

//flips above to explicit parameter use implicit parameter
fun User.queryUser(daoDatabase: DaoDatabase) = daoDatabase.query("SELECT * from Users where userId = ${this.id}")
// this is weird, it gives logic to a dumb class and also it has a global scope

// So interface and scoped extension functions time
interface DaoOperationsSyntax {
    val daoDatabase: DaoDatabase

    fun User.queryUser() = daoDatabase.query("SELECT * from Users where userId = ${this.id}")

    fun Company.queryCompany() = daoDatabase.query("SELECT * from Companies where companyId = ${this.id}")
}
// all these extension functions just exist inside the implementer

interface NetworkSyntax {
    val network: Network

    fun User.requestUser() = network.requestUser(this.id)
}

// and now create new types combining
interface RequestSyntax : DaoOperationsSyntax, NetworkSyntax {
    fun User.fetchUser()
}
