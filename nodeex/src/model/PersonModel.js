const{PrismaClient} = require('@prisma/client')

const prisma = new PrismaClient;

exports.createPerson = async(person) => {
  try{
  await prisma.person.create({
    data: {
      "hkid": person.hkid,
      "lastName": person.lastName,
      "firstName": person.firstName
    }
  })
} catch (err) {
  console.log(err)
  throw (err)
} finally {
  await prisma.$disconnect();
}
}
