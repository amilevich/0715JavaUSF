package com.example.demo.view

import com.example.demo.controllers.ApproveOrDenyController
import com.example.demo.data.CustomerApplicationJoin
import com.example.demo.modals.Approved
import com.example.demo.modals.Denied
import com.example.demo.modals.NothingSelected
import com.example.demo.viewmodel.AppJoinViewModel
import javafx.beans.property.SimpleBooleanProperty
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
            column("First Name", CustomerApplicationJoin::getFirstname2)
            column("Last Name", CustomerApplicationJoin::getLastname2)
        }
        hbox {
            alignment = Pos.CENTER
            spacing = 20.0
            button("Approve") {
                action {
                    if (appModel.item != null)
                    {
                        if (appModel.item.firstname2.value.equals(""))
                        {
                            controller.approveApp(appModel.appId.value.toInt())
                        }
                        else
                        {
                            controller.approveJointApp(appModel.appId.value.toInt())
                        }
                        tableRows.setAll(controller.allOpenApplications)
                        find(Approved::class).openModal()
                    }
                    else
                    {
                        find(NothingSelected::class).openModal()
                    }
                }
            }
            button("Deny") {
                action {

                    if (appModel.item != null)
                    {
                        if (appModel.item.firstname2.value.equals(""))
                        {
                            controller.denyApp(appModel.appId.value.toInt())
                        }
                        else
                        {
                            controller.denyJointApp(appModel.appId.value.toInt())
                        }
                        tableRows.setAll(controller.allOpenApplications)
                        find(Denied::class).openModal()
                    }
                    else
                    {
                        find(NothingSelected::class).openModal()
                    }
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
