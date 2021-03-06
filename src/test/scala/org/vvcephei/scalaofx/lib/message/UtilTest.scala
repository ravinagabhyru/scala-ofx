package org.vvcephei.scalaofx.lib.message

import org.scalatest.FunSuite
import org.joda.time.{DateTimeZone, DateTime}

class UtilTest extends FunSuite {
  test("Util.toDateString should format a DateTime") {
    assert(Util.toDateString(new DateTime(2013,9,2,0,0)) == "20130902")
  }

  test("Util.fromStringInferred should parse a full ofx date") {
    assert(Util.dateFromStringInferred("20130813070000.000[-5:CDT]").toString() == new DateTime(2013,8,13,7,0,DateTimeZone.forID("CST6CDT")).toString())
  }

  test("Util.fromStringInferred should parse a partial ofx date") {
    assert(Util.dateFromStringInferred("20130813070000.000").toString() == new DateTime(2013,8,13,7,0,DateTimeZone.UTC).toString())
  }

  test("Util.fromStringInferred should parse a partial ofx date with no fractional seconds") {
    assert(Util.dateFromStringInferred("20130813070000").toString() == new DateTime(2013,8,13,7,0, DateTimeZone.UTC).toString())
  }

  test("Util.fromStringInferred should parse a partial ofx date with no time") {
    assert(Util.dateFromStringInferred("20130813").toString() == new DateTime(2013,8,13,0,0, DateTimeZone.UTC).toString())
  }

  test("Util.fromStringInferred should parse 20140611170000[0:GMT]") {
    assert(Util.dateFromStringInferred("20140611170000[0:GMT]").toString() === new DateTime(2014, 6, 11, 17, 0, 0, DateTimeZone.forID("GMT")).toString())
  }
}
