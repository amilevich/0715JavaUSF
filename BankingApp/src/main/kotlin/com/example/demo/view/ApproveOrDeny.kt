package com.example.demo.view

import com.example.demo.controllers.ApproveOrDenyController
import com.example.demo.data.CustomerApplicationJoin
import com.example.demo.modals.Approved
import com.example.demo.modals.Denied
import com.example.demo.viewmodel.AppJoinViewModel
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Pos
import tornadofx.*

class ApproveOrDeny : Fragment("Open Applications")
{
    val controller = ApproveOrDenyController()

    private val appModel = AppJoinViewModel()

    private val tableRows = FXCollections.observableArrayList<CustomerApplicationJoin>(controller.allOpenApplications)

    override val root = vbox {
        paddingAll = 10.0
        spacing = 10.0
        minWidth = 475.0
        tableview(tableRows) {
            onUserSelect(1) {join ->
                appModel.item = join
            }
            column("Application ID",CustomerApplicationJoin::getApplicationId)
            column("First Name", CustomerApplicationJoin::getFirstname)
            column("Last Name", CustomerApplicationJoin::getLastname)
            column("Address", CustomerApplicationJoin::getAddress)
        }
        hbox {
            alignment = Pos.CENTER
            spacing = 20.0
            button("Approve") {
                action {
                    controller.approveApp(appModel.appId.value.toInt())
                    tableRows.setAll(controller.allOpenApplications)
                    find(Approved::class).openModal()
                }
            }
            button("Deny") {
                action {
                    controller.denyApp(appModel.appId.value.toInt())
                    tableRows.setAll(controller.allOpenApplications)
                    find(Denied::class).openModal()
                }
            }
            button("Done") {
                action {
                    close()
                    find(EmployeeHome::class).openWindow()
                }
            }
        }
    }
}
